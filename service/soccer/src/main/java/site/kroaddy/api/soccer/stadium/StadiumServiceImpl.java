package site.kroaddy.api.soccer.stadium;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.kroaddy.api.common.domain.Messenger;

@Service
@RequiredArgsConstructor
public class StadiumServiceImpl implements StadiumService {

    private final StadiumRepository stadiumRepository;

    @Override
    public Messenger save(StadiumModel stadium) {
        Stadium entity = toEntity(stadium);
        Stadium saved = stadiumRepository.save(entity);
        return Messenger.builder()
                .code(200)
                .message("Stadium saved successfully")
                .data(toModel(saved))
                .build();
    }

    @Override
    public Messenger saveAll(List<StadiumModel> stadiums) {
        List<Stadium> entities = stadiums.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
        List<Stadium> saved = stadiumRepository.saveAll(entities);
        return Messenger.builder()
                .code(200)
                .message("Stadiums saved successfully")
                .data(saved.stream().map(this::toModel).collect(Collectors.toList()))
                .build();
    }

    @Override
    public Messenger update(StadiumModel stadium) {
        if (stadium.getId() == 0) {
            return Messenger.builder()
                    .code(400)
                    .message("Stadium ID is required for update")
                    .build();
        }
        Stadium entity = stadiumRepository.findById((long) stadium.getId())
                .orElseThrow(() -> new RuntimeException("Stadium not found"));
        updateEntity(entity, stadium);
        Stadium updated = stadiumRepository.save(entity);
        return Messenger.builder()
                .code(200)
                .message("Stadium updated successfully")
                .data(toModel(updated))
                .build();
    }

    @Override
    public Messenger delete(String id) {
        try {
            Long stadiumId = Long.parseLong(id);
            stadiumRepository.deleteById(stadiumId);
            return Messenger.builder()
                    .code(200)
                    .message("Stadium deleted successfully")
                    .build();
        } catch (NumberFormatException e) {
            return Messenger.builder()
                    .code(400)
                    .message("Invalid stadium ID format")
                    .build();
        }
    }

    @Override
    public Messenger findById(String id) {
        try {
            Long stadiumId = Long.parseLong(id);
            Stadium stadium = stadiumRepository.findById(stadiumId)
                    .orElse(null);
            if (stadium == null) {
                return Messenger.builder()
                        .code(404)
                        .message("Stadium not found")
                        .build();
            }
            return Messenger.builder()
                    .code(200)
                    .message("Stadium found")
                    .data(toModel(stadium))
                    .build();
        } catch (NumberFormatException e) {
            return Messenger.builder()
                    .code(400)
                    .message("Invalid stadium ID format")
                    .build();
        }
    }

    @Override
    public Messenger findAll() {
        List<Stadium> stadiums = stadiumRepository.findAll();
        return Messenger.builder()
                .code(200)
                .message("Stadiums retrieved successfully")
                .data(stadiums.stream().map(this::toModel).collect(Collectors.toList()))
                .build();
    }

    private Stadium toEntity(StadiumModel model) {
        Stadium entity = new Stadium();
        if (model.getId() != 0) {
            entity.setId(model.getId());
        }
        entity.setStadiumUk(model.getStadiumId());
        entity.setStadiumName(model.getStadiumName());
        entity.setHomeTeamUk(model.getHometeamId());
        entity.setSeatCount(model.getSeatCount());
        entity.setAddress(model.getAddress());
        entity.setDdd(model.getDdd());
        entity.setTel(model.getTel());
        return entity;
    }

    private StadiumModel toModel(Stadium entity) {
        return StadiumModel.builder()
                .id(entity.getId())
                .stadiumId(entity.getStadiumUk())
                .stadiumName(entity.getStadiumName())
                .hometeamId(entity.getHomeTeamUk())
                .seatCount(entity.getSeatCount())
                .address(entity.getAddress())
                .ddd(entity.getDdd())
                .tel(entity.getTel())
                .build();
    }

    private void updateEntity(Stadium entity, StadiumModel model) {
        if (model.getStadiumId() != null) entity.setStadiumUk(model.getStadiumId());
        if (model.getStadiumName() != null) entity.setStadiumName(model.getStadiumName());
        if (model.getHometeamId() != null) entity.setHomeTeamUk(model.getHometeamId());
        if (model.getSeatCount() != null) entity.setSeatCount(model.getSeatCount());
        if (model.getAddress() != null) entity.setAddress(model.getAddress());
        if (model.getDdd() != null) entity.setDdd(model.getDdd());
        if (model.getTel() != null) entity.setTel(model.getTel());
    }
}
