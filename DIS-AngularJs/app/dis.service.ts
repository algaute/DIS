import { Injectable } from '@angular/core';
import { Headers, Http, Response, RequestOptions,RequestMethod } from '@angular/http';

import { DisplayData } from './displayData';
import { DisplayDataList } from './displayDataList';

import { Observable } from 'rxjs/Rx'

@Injectable()
export class DisService {
    private ListAllUrl = 'http://localhost:8080/displayData';  // URL to web api
    private getDataById = 'http://localhost:8080/displayData/';  // URL to web api
	private ListValidUrl = 'http://localhost:8080/displayData/valid';  // URL to web api
	private addDataUrl = 'http://localhost:8080/displayData/add/';
	private updateDataUrl = 'http://localhost:8080/displayData/update/';
	private deleteDataUrl = 'http://localhost:8080/displayData/delete/';
	
    constructor(private http: Http) { }

    private createAuthorizationHeader() {
    	let headers: Headers = new Headers();
        headers.append('Authorization', 'Basic ' + btoa('admin:admin'));
        headers.append('Access-Control-Allow-Origin', '*');
        headers.append('Content-Type', 'application/json');
    	return headers;
    }
    
    addData(displayData:DisplayData): Promise<DisplayData> {
		let body = JSON.stringify(displayData);
	
		//let options = new RequestOptions({ headers: this.createAuthorizationHeader()});

		return this.http.post(this.addDataUrl, body, { headers:this.createAuthorizationHeader() })
            		    .toPromise()
             			.then(this.extractData)
             			.catch(this.handleError);
    }
    
    updateData(displayData:DisplayData): Promise<DisplayData> {
		let body = JSON.stringify(displayData);
	
		//let options = new RequestOptions({ headers: this.createAuthorizationHeader()});

		return this.http.post(this.updateDataUrl, body, { headers:this.createAuthorizationHeader() })
            		    .toPromise()
             			.then(this.extractData)
             			.catch(this.handleError);
    }
    
    deleteData(id:number) {
		let body = JSON.stringify(id);
	
		//let options = new RequestOptions({ headers: this.createAuthorizationHeader()});

		return this.http.post(this.deleteDataUrl, body, { headers:this.createAuthorizationHeader() })
            		    .toPromise()
             			.catch(this.handleError);
    }
    
    getValidDatas(): Promise<DisplayData[]> {
   		return this.http.get(this.ListValidUrl, {body: '', headers:this.createAuthorizationHeader() })
				   		.toPromise()	
        	    	    .then(this.extractData)
            	    	.catch(this.handleError);
	}
	
	private extractData(res: Response) {
    	let body = <DisplayData>res.json();
    	return body || { };
  	}
	
  	private handleError (error: any) {
    	let errMsg = (error.message) ? error.message :	error.status ? `${error.status} - ${error.statusText}` : 'Server error';
    	console.error(errMsg); // log to console instead
    	return Observable.throw(errMsg);
  	}
	
    getAllData() {
	    return this.http.get(this.ListAllUrl, {body: '', headers:this.createAuthorizationHeader() })
	                    .toPromise()
	                    .then(res => <DisplayDataList>res.json())
	                    .then(data => { return data; },
	                    	  error=> this.handleError(error));
    }
    
    getData(id:number) {
    	//let body = JSON.stringify(id);
	    return this.http.get(this.getDataById+id, {body: '', headers:this.createAuthorizationHeader() })
	                    .toPromise()
	                    .then(res => res.json() as DisplayData);
    }
    
}