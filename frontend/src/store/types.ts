// @ts-nocheck
/**
 * Store 타입 정의
 */
import { SearchTypeValue } from '../lib/types';

export interface SearchSlice {
  searchInput: string;
  searchType: SearchTypeValue;
  setSearchInput: (input: string) => void;
  setSearchType: (type: SearchTypeValue) => void;
  resetSearch: () => void;
}

export interface UISlice {
  isLoading: boolean;
  setLoading: (loading: boolean) => void;
}

export interface StoreState extends SearchSlice, UISlice {}

