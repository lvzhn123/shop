package lvzhn.component.service;

import lvzhn.core.Context;

public interface ILoginService {

	boolean loginSuccess(Context context, String username, String password);
}
