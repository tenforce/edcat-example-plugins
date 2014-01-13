package eu.lod2.edcat.auth;

import eu.lod2.edcat.utils.Catalog;
import eu.lod2.edcat.utils.SparqlEngine;
import eu.lod2.hooks.constraints.Constraint;
import eu.lod2.hooks.constraints.Priority;
import eu.lod2.hooks.contexts.PreContext;
import eu.lod2.hooks.handlers.dcat.PreCreateHandler;
import eu.lod2.hooks.handlers.dcat.PreReadHandler;
import eu.lod2.hooks.handlers.dcat.PreUpdateHandler;
import eu.lod2.hooks.util.ActionAbortException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AuthenticationProvider implements PreCreateHandler, PreUpdateHandler, PreReadHandler {

  // --- PRIORITY

  @Override
  public Collection<Priority> getConstraints(String hook) {
    return Arrays.asList(Constraint.EARLY);
  }

  // --- HOOKS

  @Override
  public void handlePreCreate(PreContext context) throws ActionAbortException {
    authenticate(context.getRequest());
  }

  @Override
  public void handlePreUpdate(PreContext context) throws ActionAbortException {
    authenticate(context.getRequest());
  }

  @Override
  public void handlePreRead(PreContext context) throws ActionAbortException {
    authenticate(context.getRequest());
  }

  // --- ASSERT AUTHENTICATION

  private void authenticate(HttpServletRequest request) throws ActionAbortException {
    String token = request.getHeader("Authorization");
    if (null == token || !token.equals("wuk"))
      throw new ActionAbortException("illegal access");
  }
}

