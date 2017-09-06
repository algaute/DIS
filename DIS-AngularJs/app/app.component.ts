import { Component } from '@angular/core';
import { ROUTER_DIRECTIVES } from '@angular/router';

import { DisService } from './dis.service';
import './rxjs-extensions';

@Component({
    selector: 'my-app',
    templateUrl: 'app/app.component.html',
    styleUrls: ['app/app.component.css'],
    directives: [ROUTER_DIRECTIVES],
    providers: [DisService]
})
export class AppComponent {
    title = 'Display Information System';
    
    constructor() {
        localStorage.setItem('userId','admin');
    }
}


