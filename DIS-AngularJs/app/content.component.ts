import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { DomSanitizationService } from '@angular/platform-browser';

import { DisplayData } from './displayData';
import { DisService } from './dis.service';
import {Observable} from 'rxjs/Rx';


@Component({
	selector: 'my-content',
    templateUrl: 'app/content.component.html',
    styleUrls: ['app/content.component.css']
})

export class ContentComponent implements OnInit  {
	@Input() 
	data: DisplayData;
	@Output()
    public toggle = new EventEmitter<Object>();
    datas: DisplayData[]=[];
    error: string;
        
    constructor(private disService: DisService,
    			private sanitizer: DomSanitizationService)
    {
    	this.sanitizer = sanitizer;
    }
        
    transformHTML(html) {
		return this.sanitizer.bypassSecurityTrustHtml(html);
	}
	
    myTrackBy(index, displayData) {
		if (index==0) {
			return false;
		} else {
			return true;
		}
	}
	
	// Infinite recursive loop on the datas
	loopOnResult(datas:DisplayData[], i:number) {
		
		if (i >= datas.length) i=0;
		
		this.data=datas[i];
		console.log("id "+ this.data.id);	
		this.toggle.emit(this.data);
				
		var secondes=this.data.time_interval_sec;				
		i++;
				
		let timer = Observable.timer(secondes*1000);
    	let subscription=timer.subscribe(
    		value=>this.loopOnResult(datas,i),
    		err=>console.log(err),
    		() => console.log('done in '+secondes+' secondes')
    	);
        	
	}

	/*
	loopOnResult(datas:DisplayData[], i:Integer) {
		
		this.data=datas[i];
		console.log("id "+ this.data.id);	
		this.toggle.emit(this.data);
		
		function recursive(datas, toggle, i) {
			if (i >= datas.length) i=0;
			
			var displayData : DisplayData=datas[i];
			var secondes=displayData.time_interval_sec;
			var millisecondes=displayData.time_interval_sec*1000;
							
			i++;
			setTimeout(function() {
				
				console.log("wait for "+ displayData.time_interval_sec +" secondes");	
				
				this.data=displayData;
				toggle.emit(this.data);
				
				return recursive(datas,toggle, i);
			}, millisecondes);
		}	
		
		return recursive(datas, this.toggle, i)
	}
	*/
	ngOnInit() {
    	this.disService.getValidDatas().then(datas => this.loopOnResult(datas,0),
    										 error => this.error = error);
   }
}