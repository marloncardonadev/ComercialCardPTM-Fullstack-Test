import { useEffect, useState } from 'react'
import type { InventorySummary as Summary } from '../../models/product.model'
import { productApi } from '../../api/productApi'

const InventorySummary = () => {
  const [data, setData] = useState<Summary | null>(null)

  useEffect(() => {
    productApi.inventorySummary().then(setData)
  }, [])

  if (!data) return null

  return (
    <div className="card">
      <h2>Resumen de Inventario</h2>
      <p><strong>Total:</strong> ${data.totalInventoryValue}</p>
      {data.maxInventoryValueProduct && (
        <p>
          <strong>Producto con mayor valor:</strong>{' '}
          {data.maxInventoryValueProduct.name}
        </p>
      )}
    </div>
  )
}

export default InventorySummary
