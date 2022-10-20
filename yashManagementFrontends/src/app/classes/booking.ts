import { Hospital } from "./hospital";
import { Patient } from "./patient";

export class Booking {
    appointmentBookingId!:number;
    patient!:Patient;
    hospital!:Hospital;
    startDate!:string;
    endDate!:string;
}
