import type { Product } from '../../models/product.model'

interface Props {
  product: Product
  onDelete: () => void
  onEdit: () => void
}

const ProductRow = ({ product, onDelete, onEdit }: Props) => (
  <tr>
    <td>{product.name}</td>
    <td>${product.price}</td>
    <td>{product.stock}</td>
    <td>
      <button className="secondary" onClick={onEdit}>
        Editar
      </button>{' '}
      <button className="danger" onClick={onDelete}>
        Eliminar
      </button>
    </td>
  </tr>
)

export default ProductRow
