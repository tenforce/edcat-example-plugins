package eu.lod2.edcat.logger;

import eu.lod2.hooks.constraints.Priority;
import eu.lod2.hooks.contexts.PreContext;
import eu.lod2.hooks.handlers.dcat.PreCreateHandler;
import eu.lod2.hooks.handlers.dcat.PreDestroyHandler;
import eu.lod2.hooks.handlers.dcat.PreReadHandler;
import eu.lod2.hooks.handlers.dcat.PreUpdateHandler;
import eu.lod2.hooks.handlers.dcat.ActionAbortException;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * The logger writes basic information about the received requests in the logbook.
 * <p/>
 * This is a basic proof-of-concept implementation
 */
public class Logger implements PreCreateHandler, PreReadHandler, PreUpdateHandler, PreDestroyHandler {

  // --- PRIORITY

  @Override
  public Collection<Priority> getConstraints(String hook) {
    return null;
  }


  // --- HOOKS

  @Override
  public void handlePreCreate(PreContext context) throws ActionAbortException {
    getLogger().info("Creating new catalog");
  }

  @Override
  public void handlePreDestroy(PreContext context) throws ActionAbortException {
    getLogger().info("Destroying catalog");
  }

  @Override
  public void handlePreRead(PreContext context) throws ActionAbortException {
    getLogger().info("Reading catalog");
  }

  @Override
  public void handlePreUpdate(PreContext context) throws ActionAbortException {
    getLogger().info("Updating catalog");
  }


  // --- HELPERS

  /**
   * Returns the logbook to which the Logger writes by default.
   *
   * @return Logbook to which we can write.
   */
  private org.slf4j.Logger getLogger(){
    return LoggerFactory.getLogger("Logger");
  }
}
