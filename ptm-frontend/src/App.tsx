import { useEffect } from 'react'
import ProductList from './components/products/ProductList'
import InventorySummary from './components/inventory/InventorySummary'
import ProductCombinations from './components/combinations/ProductCombinations'
import CatFactsModal from './components/facts/CatFactsModal'
import UselessFactFooter from './components/facts/UselessFactFooter'

const App = () => {

  useEffect(() => {
    // carga inicial (facts)
  }, [])

  return (
    <div className="container">
      <h1>📦 Gestión de Productos</h1>

      <InventorySummary />
      <ProductCombinations />
      <ProductList />

      <CatFactsModal />
      <UselessFactFooter />
    </div>
  )
}

export default App