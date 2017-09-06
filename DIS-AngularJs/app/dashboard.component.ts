import { Component} from '@angular/core';
import { Router } from '@angular/router';

import { ContentComponent } from './content.component';

@Component({
	selector: 'my-dashboard',
    templateUrl: 'app/dashboard.component.html',
    styleUrls: ['app/dashboard.component.css'],
   	directives: [ContentComponent]
})

export class DashboardComponent {
    
    constructor(private router: Router)  {}
   
}