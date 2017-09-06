import { Component, EventEmitter, Input, OnInit, OnDestroy, Output} from '@angular/core';
import { DomSanitizationService } from '@angular/platform-browser';
import { ActivatedRoute, Router} from '@angular/router';
import { DatePipe} from '@angular/common';

import {CORE_DIRECTIVES} from '@angular/common';
import {FORM_DIRECTIVES} from '@angular/forms';

import {Calendar, Button} from 'primeng/primeng';

import { DisplayData } from './displayData';
import { DisService } from './dis.service';

declare var tinymce:any;

@Component({
	selector: 'my-admin-detail',
    templateUrl: 'app/admin-detail.component.html',
	styleUrls:  ['app/admin-detail.component.css'],
    directives:  [CORE_DIRECTIVES, FORM_DIRECTIVES, Calendar, Button]
})

export class AdminDetailComponent implements OnInit {
        
    @Input() data: DisplayData;
    @Output() close = new EventEmitter();
    
    public error: any;
    public newData:boolean=false;
    public sub:any;
    
    public validValues = [ 
        {value: true, name: "Display"}, 
        {value: false, name: "Hide"}];
    public timeValues = [ 
        {value: 1, name: "1 second"}, 
        {value: 2, name: "2 seconds"}, 
        {value: 3, name: "3 seconds"}, 
        {value: 4, name: "4 seconds"}, 
        {value: 5, name: "5 seconds"}, 
        {value: 6, name: "6 seconds"}, 
        {value: 7, name: "7 seconds"}, 
        {value: 8, name: "8 seconds"}, 
        {value: 9, name: "9 seconds"}, 
        {value: 10, name: "10 seconds"}, 
        {value: 11, name: "11 seconds"}, 
        {value: 12, name: "12 seconds"}, 
        {value: 13, name: "13 seconds"}, 
        {value: 14, name: "14 seconds"}, 
        {value: 15, name: "15 seconds"}];

    public dateFrom: string;
    public dateTo: string;
    public tinyInstance: any;
    public tinymce:any;
    public fromPage:number=1;
    
    constructor(private route: ActivatedRoute,
                private router: Router,
                private disService: DisService,
                private sanitizer: DomSanitizationService)
    {
        this.sanitizer = sanitizer;
        this.tinymce=tinymce;
    }
       
    transformHTML(html) {
        return this.sanitizer.bypassSecurityTrustHtml(html);
    }
	
    transformMilli2Date(millisecondes) {
        return new DatePipe().transform(new Date(millisecondes), 'dd-MM-yyyy');
        //return new Date(millisecondes);
    }

    transformDate2Milli(date) {
        var sdate=date.split("-");
        return new Date(sdate[2],sdate[1]-1,sdate[0]).getTime();
    }
    
    initialize(data:DisplayData) {
        this.dateFrom=this.transformMilli2Date(data.start_date_millisec);
        this.dateTo=this.transformMilli2Date(data.end_date_millisec);
        this.data=data;
    }
    
    ngOnInit() {
        console.log("ngOnInit");

        this.sub = this.route.params.subscribe(
            params => {
                if (params['id'] !== undefined && params['id'] !== null && params['id'] !=='') {
                    let id = +params['id'];
                    this.disService.getData(id).then(data => this.initialize(data));
                    this.newData = false;

                } else {
                    this.newData = true;
                    this.data = new DisplayData();
                }
                
                if (params['page'] !== undefined && params['page'] !== null && params['page'] !=='') {
                    this.fromPage= +params['page']

                } else {
                    this.fromPage=1;
                }
            }
        );
        
        setTimeout(() => {
            console.log("timeout finished");

            this.tinymce.init({
                selector: 'textarea#message', //change this to a specific class/id
                schema: 'html5',
                theme: 'modern',
                fontsize_formats: "25pt 30pt 35pt 40pt 45pt 50pt 55pt 60pt 65pt 70pt",
                plugins: [
                    'advlist autolink lists link image charmap print preview hr anchor pagebreak',
                    'searchreplace wordcount visualblocks visualchars code fullscreen',
                    'insertdatetime media nonbreaking save table contextmenu directionality',
                    'emoticons template paste textcolor colorpicker textpattern imagetools'
                ],
                toolbar1: 'undo redo | styleselect | fontselect | fontsizeselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
                toolbar2: 'print preview media | forecolor backcolor emoticons',
                image_advtab: true,
                //templates: [
                //    { title: 'Test template 1', content: 'Test 1' },
                //    { title: 'Test template 2', content: 'Test 2' }
                //],
                content_css: [
                    //'//fonts.googleapis.com/css?family=Lato:300,300i,400,400i',
                    //'//www.tinymce.com/css/codepen.min.css'
                    '/node_modules/bootstrap/dist/css/bootstrap.min.css',
                    '/tinymce.css'
                ],
                init_instance_callback : function(editor) {
                    console.log("Editor: " + editor.id + " is now initialized.");
                },
                setup : function(ed)
                {
                    ed.on('init', function() 
                    {
                        this.getDoc().body.style.fontSize = '35pt';
                    });
                }
            });
        }, 200);
        
    }
    
    ngAfterViewInit() {
        console.log("ngAfterViewInit");
    }
    
    ngOnDestroy() {
        console.log("ngOnDestroy");
        
        this.tinymce.remove();
        
        //if (tinymce.get("message")) {
        //    tinymce.get("message").remove();
        //}

        this.sub.unsubscribe();
        
    }
    
    dateFromSelected(dateFrom) {
        this.dateFrom=dateFrom;
    }
    
    dateToSelected(dateTo) {
        this.dateTo=dateTo;
    }
    
    cancel() {
        this.goBack();
        //window.history.back();
    }
    //onSubmit(form:any): void { 
    save() {
        console.log("you save value: ", this.data);
        
        this.data.start_date_millisec=this.transformDate2Milli(this.dateFrom)
        this.data.end_date_millisec=this.transformDate2Milli(this.dateTo)
        this.data.message=this.tinymce.get("message").getContent();

        if(this.newData) {
            console.log("new");
            this.disService.addData(this.data)
                //   .then(
                //        data  => this.datas.push(data),
                //        error =>  this.error = <any>error,
                //        ()=>
                //   )
                ;
        } else {
            console.log("update");
            this.disService.updateData(this.data)
                   //   .then(
                //        data  => this.datas.push(data),
                //        error =>  this.error = <any>error,
                //        ()=>
                //   )
                ;
        }
                
        this.goBack();
    }
    
    goBack() {
        setTimeout(() => {
            this.router.navigate(['/admin',this.fromPage]);
        }, 1000)
        
        
        //this.close.emit(savedData);
        //window.history.back(); 
    }        
 
}

