package ru.demo.homework02.exceptions;


import java.util.function.Supplier;

public class AuthorNotFoundException extends RuntimeException {

	public AuthorNotFoundException(String name) {
		super("Could not find author by name " + name);
	}
}
