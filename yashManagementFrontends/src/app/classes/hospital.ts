import { Doctor } from "./doctor";
import { RoomCategory } from "./room-category";
import { Speciality } from "./speciality";

export class Hospital {
    hospitalId!:number;
    address!:string;
    hospitalName!:string;
    speciality!:Speciality;
    roomCategory !:RoomCategory;
    bedCount!:number;
}
