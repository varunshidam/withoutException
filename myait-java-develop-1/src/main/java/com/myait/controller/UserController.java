package com.myait.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myait.model.User;
import com.myait.service.UserService;
import com.myait.view.UserView;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/* to get all records of Employee (Right method) */
	@GetMapping(value = "/getEmployee")
	public ResponseEntity<List<UserView>> getAll() {

		List<UserView> list = userService.showAll();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	/* to get record by AIT_id including all Parameters (Right method) */
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<User> getUserByaitId(@PathVariable String id) {
		User user = userService.findByAitid(id);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(user));
	}

//	 @ExceptionHandler(NoSuchElementFoundException.class)
//	  @ResponseStatus(HttpStatus.NOT_FOUND)
//	  public ResponseEntity<String> handleNoSuchElementFoundException(
//	      NoSuchElementFoundException exception
//	  ) {
//	    return ResponseEntity
//	        .status(HttpStatus.NOT_FOUND)
//	        .body(exception.getMessage());
//	  }

	/* to get all records of Employee 4 (Right method) */
//	@GetMapping(value = "/getAllEmployee")
//	public List<UserView> getAll() {
//		List<UserView>arr=new ArrayList<>();
//		arr=userService.showAll();
//		return arr;
//	}

//	@GetMapping(value = "/All")
//	public List<User> ShowAll(){
//		return userService.showAll();
//	}

	/* to get record by AIT id only 5 properties right way */
//	@GetMapping("/getEmployeeByAit_id/{id}")
//	public UserView getUserById11(@PathVariable String id) {
//		UserView user = userService.findByAit_id11(id);
//		return user;
//	}

	/* to get record by AIT_id including all Parameters */
//	@GetMapping("/getEmployeesByAit_id/{id}")
//	public User getUserById22(@PathVariable String id) {
//		User user = userService.findByAit_id(id);
//		return user;
//	}

	/* to get one record by User_id Right method */
//	@GetMapping(value = "/getEmployeeByUserId/{user_id}")
//	public Optional<User> getEmployeeById1(@PathVariable("user_id") int user_id) {
//		return userService.getEmployeeById(user_id);
//	}

//	@PostMapping(value = "/save")
//	public User saveEmployee(@RequestBody User user) {
//		return userService.saveEmployee(user);
//	}

//	@PutMapping(value = "/update")
//	public User updateEmployee(@RequestBody User user) {
//		return userService.saveEmployee(user);
//
//	}

}