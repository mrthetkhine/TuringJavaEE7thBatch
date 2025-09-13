import { ResolveFn } from '@angular/router';

export const userResolver: ResolveFn<any> = (route, state) => {
  console.log('userResolver route', route);
  const userId = route.paramMap.get('id')!;
  return {
    id:userId,
    name : "User "+userId,
  };
};
