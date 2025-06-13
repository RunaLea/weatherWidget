

export function useFormatDay(dateStr: string) {
  const date = new Date(dateStr)
  return date.toLocaleDateString('en-US', { weekday: 'long' })
}
