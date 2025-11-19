package site.kroaddy.api.soccer.player;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.kroaddy.api.common.domain.Messenger;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public Messenger save(PlayerModel player) {
        Player entity = toEntity(player);
        Player saved = playerRepository.save(entity);
        return Messenger.builder()
                .code(200)
                .message("Player saved successfully")
                .data(toModel(saved))
                .build();
    }

    @Override
    public Messenger saveAll(List<PlayerModel> players) {
        List<Player> entities = players.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
        List<Player> saved = playerRepository.saveAll(entities);
        return Messenger.builder()
                .code(200)
                .message("Players saved successfully")
                .data(saved.stream().map(this::toModel).collect(Collectors.toList()))
                .build();
    }

    @Override
    public Messenger update(PlayerModel player) {
        if (player.getId() == null) {
            return Messenger.builder()
                    .code(400)
                    .message("Player ID is required for update")
                    .build();
        }
        Player entity = playerRepository.findById(player.getId())
                .orElseThrow(() -> new RuntimeException("Player not found"));
        updateEntity(entity, player);
        Player updated = playerRepository.save(entity);
        return Messenger.builder()
                .code(200)
                .message("Player updated successfully")
                .data(toModel(updated))
                .build();
    }

    @Override
    public Messenger delete(String id) {
        try {
            Long playerId = Long.parseLong(id);
            playerRepository.deleteById(playerId);
            return Messenger.builder()
                    .code(200)
                    .message("Player deleted successfully")
                    .build();
        } catch (NumberFormatException e) {
            return Messenger.builder()
                    .code(400)
                    .message("Invalid player ID format")
                    .build();
        }
    }

    @Override
    public Messenger findById(String id) {
        try {
            Long playerId = Long.parseLong(id);
            Player player = playerRepository.findById(playerId)
                    .orElse(null);
            if (player == null) {
                return Messenger.builder()
                        .code(404)
                        .message("Player not found")
                        .build();
            }
            return Messenger.builder()
                    .code(200)
                    .message("Player found")
                    .data(toModel(player))
                    .build();
        } catch (NumberFormatException e) {
            return Messenger.builder()
                    .code(400)
                    .message("Invalid player ID format")
                    .build();
        }
    }

    @Override
    public Messenger findAll() {
        List<Player> players = playerRepository.findAll();
        return Messenger.builder()
                .code(200)
                .message("Players retrieved successfully")
                .data(players.stream().map(this::toModel).collect(Collectors.toList()))
                .build();
    }

    private Player toEntity(PlayerModel model) {
        Player entity = new Player();
        entity.setId(model.getId());
        entity.setPlayerUk(model.getPlayerId());
        entity.setPlayerName(model.getPlayerName());
        entity.setEPlayerName(model.getEPlayerName());
        entity.setNickname(model.getNickname());
        entity.setJoinYyyy(model.getJoinYyyy());
        entity.setPosition(model.getPosition());
        entity.setBackNo(model.getBackNo());
        entity.setNation(model.getNation());
        entity.setBirthDate(model.getBirthDate());
        entity.setSolar(model.getSolar());
        entity.setHeight(model.getHeight());
        entity.setWeight(model.getWeight());
        entity.setTeamUk(model.getTeamId());
        return entity;
    }

    private PlayerModel toModel(Player entity) {
        return PlayerModel.builder()
                .id(entity.getId())
                .playerId(entity.getPlayerUk())
                .playerName(entity.getPlayerName())
                .ePlayerName(entity.getEPlayerName())
                .nickname(entity.getNickname())
                .joinYyyy(entity.getJoinYyyy())
                .position(entity.getPosition())
                .backNo(entity.getBackNo())
                .nation(entity.getNation())
                .birthDate(entity.getBirthDate())
                .solar(entity.getSolar())
                .height(entity.getHeight())
                .weight(entity.getWeight())
                .teamId(entity.getTeamUk())
                .build();
    }

    private void updateEntity(Player entity, PlayerModel model) {
        if (model.getPlayerId() != null) entity.setPlayerUk(model.getPlayerId());
        if (model.getPlayerName() != null) entity.setPlayerName(model.getPlayerName());
        if (model.getEPlayerName() != null) entity.setEPlayerName(model.getEPlayerName());
        if (model.getNickname() != null) entity.setNickname(model.getNickname());
        if (model.getJoinYyyy() != null) entity.setJoinYyyy(model.getJoinYyyy());
        if (model.getPosition() != null) entity.setPosition(model.getPosition());
        if (model.getBackNo() != null) entity.setBackNo(model.getBackNo());
        if (model.getNation() != null) entity.setNation(model.getNation());
        if (model.getBirthDate() != null) entity.setBirthDate(model.getBirthDate());
        if (model.getSolar() != null) entity.setSolar(model.getSolar());
        if (model.getHeight() != null) entity.setHeight(model.getHeight());
        if (model.getWeight() != null) entity.setWeight(model.getWeight());
        if (model.getTeamId() != null) entity.setTeamUk(model.getTeamId());
    }
}
