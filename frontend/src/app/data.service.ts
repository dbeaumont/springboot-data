import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { DataModel } from '../interfaces/data.interface';
import { environment } from '../environments/environment';
import { tap, timeout } from 'rxjs/operators';
import { EMPTY, empty, of } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private apiUrl = `${environment.apiUrl}/data`;

  httpOptions = {
    headers: new HttpHeaders({ 
      'Content-Type': 'application/json', 
      'Access-Control-Allow-Origin':'*',
      'Access-Control-Allow-Methods':'*',
    })
  };

  constructor(private http: HttpClient) { }

  getData(): Observable<DataModel[]> {
    return this.http.get<DataModel[]>(this.apiUrl)
      .pipe(
        tap(data => console.log('data.service.ts get: ', data)),
        retry(3),
        timeout(5000), // 5 secondes de timeout        
        catchError(this.handleError)
      );
  }

  postData(data: DataModel): Observable<DataModel> {
    return this.http.post<DataModel>(this.apiUrl, data, this.httpOptions)
      .pipe(
        tap(data => console.log('data.service.ts post: ', data)),
        timeout(5000), // 5 secondes de timeout        
        catchError(this.handleError)
      );
  }

  private handleError(error: any): Observable<never> {
    console.error('An error occurred:', error);
    throw new Error('Something went wrong; please try again later.');
  }

}
