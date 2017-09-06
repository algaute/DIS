import { provideRouter, RouterConfig }  from '@angular/router';

import { AdminComponent } from './admin.component';
import { AdminDetailComponent } from './admin-detail.component';
import { DashboardComponent } from './dashboard.component';


const routes: RouterConfig = [
	{
		path: 'admin',
		component: AdminComponent
	},
    {
        path: 'admin/:page',
        component: AdminComponent
    },
    {
		path: 'detail/:id/:page',
		component: AdminDetailComponent
	},
    {
        path: 'detail/:page',
        component: AdminDetailComponent
    },
    {
        path: 'dashboard',
        component: DashboardComponent
    },
	{
		path: '',
		redirectTo: '/dashboard',
		pathMatch: 'full'
	}
];

export const appRouterProviders = [
  provideRouter(routes)
];