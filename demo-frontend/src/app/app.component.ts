import { NgClass } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { lastValueFrom } from 'rxjs';

interface Message {
  id?: number;
  name: string;
  message: string;
  createdAt?: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  imports: [FormsModule, NgClass],
  styleUrl: './app.component.css'
})
export class AppComponent {
  
  newMessage: Message = {
    name: "",
    message: ""
  }

  messages: Message[] = [];

  constructor(private httpClient: HttpClient) {

  }

  async sendMessage() {
    await lastValueFrom(this.httpClient.post<Message>("/api/messages", this.newMessage));
    await this.loadMessages();
  }

  async loadMessages() {
    this.messages = await lastValueFrom(this.httpClient.get<Message[]>("/api/messages"));
    console.log(this.messages);
  }


  ngOnInit() {
    this.loadMessages();
    setInterval(() => {
      this.loadMessages();
    }, 1000);
  }
}
