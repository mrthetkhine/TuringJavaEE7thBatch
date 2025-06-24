package com.turing.javaee7.jpa.model.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Actor extends Human{

	@Override
	public String toString() {
		return "Actor [firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday + ", gender="
				+ gender + ", id=" + id + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
