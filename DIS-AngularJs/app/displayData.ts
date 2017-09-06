import { IDisplayData } from './idisplayData';

export class DisplayData implements IDisplayData{
	id: number;
    message: string;
    start_date_millisec: number;
    end_date_millisec: number;
    time_interval_sec: number;
    valid: boolean;
    notes: string;
    image: string;
    created_by: string;
    created_on: number;
    subject: string;
    the_order: number;

	constructor() {
		this.created_by=localStorage.getItem('userId');
		this.created_on=new Date().getTime();
		this.the_order=0;
		this.valid=true;
		this.start_date_millisec=new Date().getTime();
		
		let date = new Date();
  		date.setDate(date.getDate() + 2);
  		
  		this.end_date_millisec=date.getTime();
  		this.time_interval_sec=1;
	}
}