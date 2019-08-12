package ru.demo.homework02.exceptions;



public class AuthorNotFoundException extends RuntimeException {

	public AuthorNotFoundException(String name) {
		super("Could not find author by name " + name);
	}
}
