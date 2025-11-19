// @ts-nocheck
"use client";

import { create } from 'zustand';
import { SearchType, SearchTypeValue } from '../lib/types';

/**
 * 검색 Slice - 검색 관련 상태 및 액션
 */
interface SearchSlice {
  searchInput: string;
  searchType: SearchTypeValue;
  setSearchInput: (input: string) => void;
  setSearchType: (type: SearchTypeValue) => void;
  resetSearch: () => void;
}

/**
 * UI Slice - UI 상태 관리
 */
interface UISlice {
  isLoading: boolean;
  setLoading: (loading: boolean) => void;
}

/**
 * 통합 Store State
 */
interface StoreState extends SearchSlice, UISlice { }

/**
 * 검색 Slice 생성
 */
const createSearchSlice = (set: any): SearchSlice => ({
  searchInput: '',
  searchType: SearchType.PLAYER,
  setSearchInput: (input) => set({ searchInput: input }),
  setSearchType: (type) => set({ searchType: type }),
  resetSearch: () => set({
    searchInput: '',
    searchType: SearchType.PLAYER,
  }),
});

/**
 * UI Slice 생성
 */
const createUISlice = (set: any): UISlice => ({
  isLoading: false,
  setLoading: (loading) => set({ isLoading: loading }),
});

/**
 * Zustand Store 생성 (SSR 호환)
 * - 클라이언트 사이드에서만 동작하도록 보장
 * - Slice 패턴으로 논리적 분리
 */
export const useStore = create<StoreState>((set) => ({
  ...createSearchSlice(set),
  ...createUISlice(set),
}));

