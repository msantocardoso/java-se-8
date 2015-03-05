package br.com.cespec.java.foreach;

import java.util.function.Consumer;

import org.apache.log4j.Logger;

import br.com.cespec.java.foreach.model.Usuario;

public class UsuarioConsumer implements Consumer<Usuario> {

	private final Logger LOGGER = Logger.getLogger(UsuarioConsumer.class);

	@Override
	public void accept(Usuario pUsuario) {
		LOGGER.info(this.getClass().getSimpleName() +": " + pUsuario);
	}
}
