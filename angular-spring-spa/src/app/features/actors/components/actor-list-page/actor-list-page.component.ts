import {Component, inject, TemplateRef, viewChild} from '@angular/core';
import {Actor} from "../../../../core/model/actor.model";
import {ActorUiComponent} from "../../../../core/components/actor-ui/actor-ui.component";
import {FormBuilder, ReactiveFormsModule, Validators} from "@angular/forms";
import {BsModalRef, BsModalService} from "ngx-bootstrap/modal";
import {ActorService} from "../../../../core/services/actor.service";
import Swal from "sweetalert2";

@Component({
  selector: 'app-actor-list-page',
  standalone: true,
  imports: [
    ActorUiComponent,
    ReactiveFormsModule,
  ],
  providers: [BsModalService],
  templateUrl: './actor-list-page.component.html',
  styleUrl: './actor-list-page.component.css'
})
export class ActorListPageComponent {
  modalRef?: BsModalRef;
  modalService = inject(BsModalService);
  actorFormDlg = viewChild<TemplateRef<void>>('actorFormDlg');

  private formBuilder = inject(FormBuilder);
  actorForm = this.formBuilder.group({
    id: ['',],
    firstName: ['', [
      Validators.required
    ]
    ],
    lastName: ['',[
      Validators.required
    ]
    ],
    gender: ['',[
      Validators.required,
    ]
    ],

  });
  actorService = inject(ActorService);
  actors: Actor[]= [
   /* {
      "id": "68a083e9a3ee5ecf75cc1a0b",
      "firstName": "Leonardo",
      "lastName": "Decaprio",
      "gender": "Male"
    },
    {
      "id": "68a0845ef589a3b9b1ac36c2",
      "firstName": "Kate",
      "lastName": "Winselect",
      "gender": "Female"
    },
    {
      "id": "68a08546d1078ad3a9525ff3",
      "firstName": "Keanu",
      "lastName": "Reeves",
      "gender": "Male"
    },*/
  ];
  ngOnInit(): void {
    this.actorService.actors.subscribe(data=>{
      this.actors = data;
    });
    this.actorService.loadAllActors();

  }
  get firstName() {
    return this.actorForm.get('firstName');
  }
  get lastName() {
    return this.actorForm.get('lastName');
  }
  get gender() {
    return this.actorForm.get('gender');
  }
  openModal(template: TemplateRef<void>) {
    this.modalRef = this.modalService.show(template,{ class: 'modal-lg' });
  }
  showNewActorDialog()
  {
    this.openModal(this.actorFormDlg()!);
  }
  onSubmit()
  {
    console.log('Form ',this.actorForm.value);
    let actor:Actor = this.actorForm.value as any;
    this.actorService.saveActor(actor,()=>{
      this.modalRef?.hide();
      Swal.fire({
        title: 'Success!',
        icon: "success",
        titleText: 'Actor saved successfully',
        confirmButtonText: 'Ok'
      });

      this.actorForm.reset();
    });
  }
}
