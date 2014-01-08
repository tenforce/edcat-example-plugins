package eu.lod2.edcat.auth;

import eu.lod2.edcat.utils.SparqlEngine;
import eu.lod2.hooks.constraints.Constraint;
import eu.lod2.hooks.constraints.Priority;
import eu.lod2.hooks.handlers.dcat.PreCreateHandler;
import eu.lod2.hooks.handlers.dcat.PreReadHandler;
import eu.lod2.hooks.handlers.dcat.PreUpdateHandler;
import eu.lod2.hooks.util.ActionAbortException;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

public class AuthenticationProvider implements PreCreateHandler,PreUpdateHandler,PreReadHandler {

  @Override
  public void handlePreCreate(HttpServletRequest request, SparqlEngine engine) throws ActionAbortException {
    authenticate(request);
  }

  @Override
  public void handlePreUpdate(HttpServletRequest request, SparqlEngine engine) throws ActionAbortException {
    authenticate(request);
  }


  private void authenticate(HttpServletRequest request) throws ActionAbortException {
    String token = request.getHeader("Authorization");
    if (null == token || !token.equals("wuk"))
      throw new ActionAbortException("illegal access");
  }

  public List<Priority> getConstraintsFor(String hook) {
    return Arrays.asList(Constraint.EARLY,Constraint.before("com.bleh.foo.Bar"));
  }


}

