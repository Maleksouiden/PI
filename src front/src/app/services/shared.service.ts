import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class SharedService {
  myVariable: any;

  constructor() {}

  setMyVariable(value: any) {
    this.myVariable = value;
    console.log(value);
  }

  getMyVariable() {
    return this.myVariable;
  }
}
