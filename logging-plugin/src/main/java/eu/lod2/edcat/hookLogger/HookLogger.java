package eu.lod2.edcat.hookLogger;

import eu.lod2.hooks.constraints.Priority;
import eu.lod2.hooks.handlers.OptionalHookHandler;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * This logger provides an implementation which hooks into any hook and
 */
public class HookLogger implements OptionalHookHandler {
  @Override
  public boolean isHandlingHook( String hook ) {
    return true;
  }

  @Override
  public void handle( String hook, Object... args ) {
    LoggerFactory.getLogger( this.getClass() ).info( "Ran " + hook + " with arguments " + args.toString() );
  }

  @Override
  public Collection<Priority> getConstraints( String hook ) {
    return null;
  }
}


