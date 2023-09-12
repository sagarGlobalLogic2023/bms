package com.example.Book.my.show;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.Book.my.show.Service.UserService;
import com.example.Book.my.show.models.userEntity;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private UserService userService;

// =======================================
// ==============================================================
	@Override
	public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
		initDatabaseEntities();
	}

	// ==============================================================
	// 
	// ==============================================================
	private void initDatabaseEntities() {

		// ==============================================================
		// = Only When if the User Table Is Empty
		// ==============================================================
		if (userService.getAllUser().size() == 0) {

			// ==============================================================
			// = Registering Admin
			// =================================================================
			userService.save(new userEntity("admin", "admin@gmail.com", "admin", "ROLE_ADMIN"));

			

		}

	}
}