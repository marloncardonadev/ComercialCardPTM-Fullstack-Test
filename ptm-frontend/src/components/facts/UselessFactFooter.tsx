import { useEffect, useState } from 'react'

interface UselessFactResponse {
  text: string
}

const UselessFactFooter = () => {
  const [fact, setFact] = useState<string>('')

  useEffect(() => {
    const loadFact = async () => {
      try {
        const res = await fetch(
          'https://uselessfacts.jsph.pl/api/v2/facts/today'
        )
        const json: UselessFactResponse = await res.json()
        setFact(json.text)
      } catch (error) {
        console.error('Error cargando useless fact', error)
      }
    }

    loadFact()
  }, [])

  if (!fact) return null

  return (
    <footer className="footer">
      <strong>🤯 Dato inútil del día:</strong> {fact}
    </footer>
  )
}

export default UselessFactFooter
