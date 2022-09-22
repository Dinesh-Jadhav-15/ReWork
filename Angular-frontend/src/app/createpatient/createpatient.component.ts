import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { IDoctor } from '../model/iDoctor';
import { IPatient } from '../model/iPatient';
import { HospitalserviceService } from '../service/hospitalservice.service';

@Component({
  selector: 'app-createpatient',
  templateUrl: './createpatient.component.html',
  styleUrls: ['./createpatient.component.css'],
})
export class CreatepatientComponent implements OnInit {
  public patient: IPatient = {} as IPatient;
  public doctors: IDoctor[] = {} as IDoctor[];
  public errorMessage: string | null = null;

  constructor(
    private service: HospitalserviceService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.service.getAllDoctors().subscribe({
      next: (data) => {
        this.doctors = data;
      },
    });
  }
  savePatient() {
    this.service.CreatePatient(this.patient).subscribe({
      next: (data) => {
        this.router.navigate(['/']).then();
        Swal.fire(
          'Thank you...',
          'Patient Added in to the database succesfully!',
          'success'
        );
      },
      error: (e) => {
        this.errorMessage = e;
        console.warn(e);

        Swal.fire('Error...!', 'Invalid Information', 'error');

        this.router.navigate(['/patients/patient/add']).then();
      },
    });
  }
}
