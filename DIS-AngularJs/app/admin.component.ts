import { Component, OnInit, EventEmitter, Output} from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DomSanitizationService } from '@angular/platform-browser';

import { DatePipe } from '@angular/common';

import { DisplayDataList } from './displayDataList';
import { DisplayData } from './displayData';
import { AdminDetailComponent } from './admin-detail.component';
import { DisService } from './dis.service';
import { OrderBy } from './orderby';

@Component({
	selector: 'my-admin',
	templateUrl: 'app/admin.component.html', 
	styleUrls:  ['app/admin.component.css'],
    directives: [AdminDetailComponent],
    pipes: [ OrderBy ]
})

export class AdminComponent implements OnInit {
        
    public datas: DisplayData[];
    public selectedData: DisplayData;
    public error: any;
    public sub:any;
    
    @Output() init = new EventEmitter();
    
    public duration_order:string="-time_interval_sec";
    
    public pages: number[]=[];
    public currentPage:number = 1;  
    public maxPages:number = 3;  // max pages in the pagination view
    public totalPages:number = 0;
    
    public totalItems:number = 0;
    public maxItems:number = 10;
    
    constructor(private route: ActivatedRoute,
                private router: Router,
                private disService: DisService,
                private sanitizer: DomSanitizationService)
    {
        this.sanitizer = sanitizer;
    }
       
    transformHTML(html) {
        return this.sanitizer.bypassSecurityTrustHtml(html);
    }
	
    transformMilli2Date(millisecondes) {
        return new DatePipe().transform(new Date(millisecondes), 'dd-MM-yyyy');
    }

    addNewData() {
        console.log("addNewData")
        
        this.router.navigate(['/detail',this.currentPage]);
    }
    
    onRowSelect(data) {
        console.log("onRowSelect");
        if (this.selectedData==data)
            this.selectedData=null;
        else
            this.selectedData=data;
    }
    
    updateData(data,event) {
        console.log("updateData")
        
        this.router.navigate(['/detail', data.id, this.currentPage]);
        
        event.stopPropagation();
    }
    
    deleteData(data,event) {
        console.log("deleteData")
        
        this.disService.deleteData(data.id);

        this.datas.splice(this.findSelectedDataIndex(data), 1);
        
        event.stopPropagation();
    }    
    
    findSelectedDataIndex(data:DisplayData): number {
        for(var i=0;i<=this.datas.length;i++)
        {
            if (this.datas[i].id==data.id) {
                return i;
            }
        }
        return -1;      
    }
    
    public paginateToBegin():void {
        this.currentPage = 1;    
    }
    
    public paginateMoins(pageNo:number):void {
        this.currentPage=pageNo-1;    
    }
    
    public paginateToEnd():void {
        this.currentPage = Math.floor(this.totalItems/this.maxItems)
        var rem = this.totalItems % this.maxItems;
        if (rem > 0) {
            this.currentPage++;
        };
    }
     
    public paginatePlus(pageNo:number):void {
        this.currentPage = pageNo+1;    
    }
    
    public setPage(pageNo:number):void {
        this.currentPage = pageNo;    
    }
    
   
    initialize(datas:DisplayDataList) {
        this.totalItems=datas.items; // total number of items
        this.totalPages = Math.floor(this.totalItems/this.maxItems);
        var rem = this.totalItems % this.maxItems;
        if (rem > 0) {
            this.totalPages++;
        }
        for(var i=0;i<this.totalPages;i++) {
            this.pages[i]=i+1;
        }        
        this.datas=datas.displayDatas;
    }
    
    ngOnInit() {
        this.sub = this.route.params.subscribe(
            params => {
                if (params['page'] !== undefined && params['page'] !== null && params['page'] !=='') {
                    this.currentPage= +params['page']

                } else {
                    this.currentPage=1;
                }
            }
        );
        
        
        console.log("admin.component ngOnInit");
        this.disService.getAllData().then(datas => this.initialize(datas),
                                          error => this.error=error);   
      
        
        //setTimeout(() => {
        //    this.initialized = true;
        //}, 2000)
    }

    
    ngAfterViewInit() {
        console.log("admin.component ngAfterViewInit");
        
        this.init.emit(this.datas);

    }
    
    
    /*
    ngOnDestroy() {
        console.log("admin.component ngOnDestroy");
        // Speak now or forever hold your peace
    }
    ngDoCheck() {
        console.log("admin.component ngDoCheck");
        // Custom change detection
    }
    ngOnChanges(changes) {
        console.log("admin.component ngOnChanges");
        // Called right after our bindings have been checked but only
        // if one of our bindings has changed.
        //
        // changes is an object of the format:
        // {
        //   'prop': PropertyUpdate
        // }
    }
    ngAfterContentInit() {
        console.log("admin.component ngAfterContentInit");
        // Component content has been initialized
    }
    ngAfterContentChecked() {
        console.log("admin.component ngAfterContentChecked");
        // Component content has been Checked
    }
    ngAfterViewInit() {
        console.log("admin.component ngAfterViewInit");
        // Component views are initialized
    }
    ngAfterViewChecked() {
        console.log("admin.component ngAfterViewChecked");
        // Component views have been checked
    } 
    */
}

