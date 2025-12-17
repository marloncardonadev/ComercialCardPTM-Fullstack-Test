import { useState } from 'react'
import { useProducts } from '../../hooks/useProducts'
import ProductRow from './ProductRow'
import ProductForm from './ProductForm'
import type { Product } from '../../models/product.model'

const ProductList = () => {
  const { products, deleteProduct } = useProducts()
  const [sortAsc, setSortAsc] = useState(true)
  const [editing, setEditing] = useState<Product | null>(null)

  const sorted = [...products].sort((a, b) =>
    sortAsc ? a.price - b.price : b.price - a.price
  )

  return (
    <div className="card">
      <h2>Productos</h2>

      <button className="secondary" onClick={() => setSortAsc(!sortAsc)}>
        Ordenar por precio
      </button>

      <ProductForm
        product={editing ?? undefined}
        onFinish={() => setEditing(null)}
      />

      <table>
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Stock</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {sorted.map(p => (
            <ProductRow
              key={p.id}
              product={p}
              onEdit={() => setEditing(p)}
              onDelete={() => deleteProduct(p.id)}
            />
          ))}
        </tbody>
      </table>
    </div>
  )
}

export default ProductList
