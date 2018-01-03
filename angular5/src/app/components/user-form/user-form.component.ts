import {Component, OnInit} from '@angular/core';
import {User} from '../../user';
import {Router} from '@angular/router';
import {UserService} from '../../shared-service/user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  private user: User;

  constructor(private _userService: UserService, private _router: Router) {}

  ngOnInit() {
    this.user = this._userService.getter();
  }

  back() {
    this._router.navigate(['/']);
  }

  createUser() {
    this._userService.createUser(this.user).subscribe((user) => {
      console.log(user);
      this._router.navigate(['/']);
    }, (error) => {
      console.log(error);
    });
  }

  updateUser() {
    this._userService.updateUser(this.user).subscribe((user) => {
      console.log(user);
      this._router.navigate(['/']);
    }, (error) => {
      console.log(error);
    });
  }


  processForm() {
       this.updateUser();
        this.createUser();
  }

}

