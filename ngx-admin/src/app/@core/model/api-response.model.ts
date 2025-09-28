export interface ApiResponse<T> {
  "code": string,
  "message": string,
  "error": any,
  "data":T,
}
