export interface Product {
  id: number
  name: string
  description: string
  price: number
  stock: number
  inventoryValue: number
}

export interface ProductRequest {
  name: string
  description?: string
  price: number
  stock: number
}

export interface InventorySummary {
  totalInventoryValue: number
  maxInventoryValueProduct: Product | null
}

export interface CombinationItem {
  productNames: string[]
  sumPrices: number
}