package pi.vezbe.config;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

/*public class ServerPasswordCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			WSPasswordCallback pc = (WSPasswordCallback) callbacks[i];

			if (pc.getUsage() == WSPasswordCallback.SIGNATURE || pc.getUsage() == WSPasswordCallback.DECRYPT) {
				if (pc.getIdentifier().equals("server")) {
					pc.setPassword("keyServerPass");
				}
			}
		}
	}*/


