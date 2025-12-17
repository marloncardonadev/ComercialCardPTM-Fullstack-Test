import axios from 'axios'
import type {
    Product,
    ProductRequest,
    InventorySummary,
    CombinationItem
} from '../models/product.model'

const api = axios.create({
  baseURL: 'http://localhost:8080/api/products'
})

export const productApi = {

  getAll: async (): Promise<Product[]> => {
    const res = await api.get('')
    return res.data
  },

  create: async (data: ProductRequest): Promise<Product> => {
    const res = await api.post('', data)
    return res.data
  },

  update: async (id: number, data: ProductRequest): Promise<Product> => {
    const res = await api.put(`/${id}`, data)
    return res.data
  },

  delete: async (id: number): Promise<void> => {
    await api.delete(`/${id}`)
  },

  inventorySummary: async (): Promise<InventorySummary> => {
    const res = await api.get('/inventory/summary')
    return res.data
  },

  combinations: async (budget: number): Promise<CombinationItem[]> => {
    const res = await api.post('/combinations', { budget })
    return res.data
  }
}