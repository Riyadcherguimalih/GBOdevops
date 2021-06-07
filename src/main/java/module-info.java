module ObjectifProject2 {
	exports ma.gbp.objectif.gestion.repository;
	exports ma.gbp.objectif.gestion;
	exports ma.gbp.objectif.gestion.controller;
	exports ma.gbp.objectif.gestion.utils;
	exports ma.gbp.objectif.gestion.service;
	exports ma.gbp.objectif.gestion.model.objectif;
	exports ma.gbp.objectif.gestion.model.authentification;
	exports ma.gbp.objectif.gestion.model.products;

	requires com.fasterxml.jackson.annotation;
	requires java.persistence;
	requires org.apache.commons.lang3;
	requires spring.beans;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.core;
	requires spring.data.commons;
	requires spring.data.jpa;
	requires spring.tx;
	requires spring.web;
}