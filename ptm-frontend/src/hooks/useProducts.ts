import { useEffect, useState } from 'react'
import { productApi } from '../api/productApi'
import type { Product, ProductRequest } from '../models/product.model'

export const useProducts = () => {
  const [products, setProducts] = useState<Product[]>([])
  const [loading, setLoading] = useState(false)

  const loadProducts = async () => {
    setLoading(true)
    try {
      setProducts(await productApi.getAll())
    } finally {
      setLoading(false)
    }
  }

  const createProduct = async (data: ProductRequest) => {
    await productApi.create(data)
    loadProducts()
  }

  const updateProduct = async (id: number, data: ProductRequest) => {
    await productApi.update(id, data)
    loadProducts()
  }

  const deleteProduct = async (id: number) => {
    await productApi.delete(id)
    loadProducts()
  }

  useEffect(() => {
    loadProducts()
  }, [])

  return {
    products,
    loading,
    createProduct,
    updateProduct,
    deleteProduct
  }
}