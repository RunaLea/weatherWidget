

export function useFormatHour(iso: string) {
  const date = new Date(iso)
  return date.getHours().toString().padStart(2, '0') + ':00'
}