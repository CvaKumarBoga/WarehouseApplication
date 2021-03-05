package com.app.generator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomGeneratorDebit implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		String prefix="DEB";
		String format = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
		int nextInt = new Random().nextInt(1000);
		return prefix+format+nextInt;
	}

}
