import { useEffect, useState } from 'react'
import type { Product, ProductRequest } from '../../models/product.model'
import { useProducts } from '../../hooks/useProducts'

interface Props {
  product?: Product
  onFinish?: () => void
}

const ProductForm = ({ product, onFinish }: Props) => {
  const { createProduct, updateProduct } = useProducts()

  const [name, setName] = useState('')
  const [price, setPrice] = useState(0)
  const [stock, setStock] = useState(0)

  useEffect(() => {
    if (product) {
      setName(product.name)
      setPrice(product.price)
      setStock(product.stock)
    }
  }, [product])

  const submit = async () => {
    const data: ProductRequest = { name, price, stock }

    if (product) {
      await updateProduct(product.id, data)
    } else {
      await createProduct(data)
    }

    setName('')
    setPrice(0)
    setStock(0)
    onFinish?.()
  }

  return (
    <div className="card">
      <h3>{product ? 'Actualizar Producto' : 'Agregar Producto'}</h3>

      <div className="form-row">
        <input
          placeholder="Nombre"
          value={name}
          onChange={e => setName(e.target.value)}
        />
        <input
          type="number"
          placeholder="Precio"
          value={price}
          onChange={e => setPrice(+e.target.value)}
        />
        <input
          type="number"
          placeholder="Stock"
          value={stock}
          onChange={e => setStock(+e.target.value)}
        />
        <button onClick={submit}>
          {product ? 'Actualizar' : 'Guardar'}
        </button>
      </div>
    </div>
  )
}

export default ProductForm
