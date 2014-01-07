import eu.lod2.edcat.handler.ActionAbortException;
import eu.lod2.edcat.constraints.Constraint;
import eu.lod2.edcat.handler.PreCreateHandler;
import eu.lod2.edcat.handler.PreReadHandler;
import eu.lod2.edcat.handler.PreUpdateHandler;
import eu.lod2.edcat.constraints.Priority;
import eu.lod2.edcat.utils.SparqlEngine;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Repository
public class Authentication implements PreCreateHandler,PreUpdateHandler,PreReadHandler {

  @Override
  public void handlePreCreate(HttpServletRequest request, SparqlEngine engine) throws ActionAbortException {
    authenticate(request);
  }

  @Override
  public void handlePreUpdate(HttpServletRequest request, SparqlEngine engine) throws ActionAbortException {
    authenticate(request);
  }


  private void authenticate(HttpServletRequest request) throws ActionAbortException {
    if (!request.getHeader("Authorization").equals("wuk"))
      throw new ActionAbortException("illegal access");
  }

  public List<Priority> getConstraintsFor(String hook) {
    return Arrays.asList(Constraint.EARLY,Constraint.before("com.bleh.foo.Bar"));
  }


}

