import { useEffect, useState } from 'react'

interface CatFactResponse {
  data: string[]
}

const CatFactsModal = () => {
  const [facts, setFacts] = useState<string[]>([])
  const [open, setOpen] = useState(true)

  useEffect(() => {
    const loadFacts = async () => {
      try {
        // MeowFacts API (2 facts)
        const res = await fetch('https://meowfacts.herokuapp.com/?count=2')
        const json: CatFactResponse = await res.json()

        // Traducción al español usando Google Translate (endpoint libre)
        const translated = await Promise.all(
          json.data.map(async fact => {
            const tRes = await fetch(
              `https://translate.googleapis.com/translate_a/single?client=gtx&sl=en&tl=es&dt=t&q=${encodeURIComponent(
                fact
              )}`
            )
            const tJson = await tRes.json()
            return tJson[0][0][0]
          })
        )

        setFacts(translated)
      } catch (error) {
        console.error('Error cargando datos de gatos', error)
      }
    }

    loadFacts()
  }, [])

  if (!open || facts.length === 0) return null

  return (
    <div className="modal-backdrop">
      <div className="modal">
        <h2>🐱 Sabías que...</h2>

        <ul>
          {facts.map((fact, idx) => (
            <li key={idx}>{fact}</li>
          ))}
        </ul>

        <button onClick={() => setOpen(false)}>Cerrar</button>
      </div>
    </div>
  )
}

export default CatFactsModal
