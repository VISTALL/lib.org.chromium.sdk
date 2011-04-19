// Generated source.
// Generator: org.chromium.sdk.internal.wip.tools.protocolgenerator.Generator
// Origin: http://svn.webkit.org/repository/webkit/trunk/Source/WebCore/inspector/Inspector.json@84080

package org.chromium.sdk.internal.wip.protocol.output.debugger;

/**
Continues execution until specific location is reached.
 */
public class ContinueToLocationParams extends org.chromium.sdk.internal.wip.protocol.output.WipParams {
  public static final String METHOD_NAME = org.chromium.sdk.internal.wip.protocol.BasicConstants.Domain.DEBUGGER + ".continueToLocation";

  /**
   @param location Location to continue to.
   */
  public ContinueToLocationParams(org.chromium.sdk.internal.wip.protocol.input.debugger.LocationValue location) {
    this.put("location", location);
  }

  @Override protected String getRequestName() {
    return METHOD_NAME;
  }

}
