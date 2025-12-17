import { useState } from 'react'
import { productApi } from '../../api/productApi'
import type { CombinationItem } from '../../models/product.model'

const ProductCombinations = () => {
  const [budget, setBudget] = useState(0)
  const [items, setItems] = useState<CombinationItem[]>([])

  const search = async () => {
    setItems(await productApi.combinations(budget))
  }

  return (
    <div className="card">
      <h2>Combinaciones por presupuesto</h2>

      <div className="form-row">
        <input
          type="number"
          value={budget}
          onChange={e => setBudget(+e.target.value)}
          placeholder="Presupuesto"
        />
        <button onClick={search}>Buscar</button>
      </div>

      <ul style={{ marginTop: '15px' }}>
        {items.map((i, idx) => (
          <li key={idx}>
            [{i.productNames.join(', ')}] = ${i.sumPrices}
          </li>
        ))}
      </ul>
    </div>
  )
}

export default ProductCombinations
