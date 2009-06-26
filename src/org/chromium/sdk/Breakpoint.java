// Copyright (c) 2009 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.sdk;

/**
 * A breakpoint in the browser JavaScript virtual machine. The {@code set*}
 * method invocations will not take effect until
 * {@link #flush(org.chromium.sdk.BrowserTab.BreakpointCallback)} is called.
 */
public interface Breakpoint {

  /**
   * Known breakpoint types.
   */
  public enum Type {
    FUNCTION,
    SCRIPT, ;
  }

  /**
   * This value is used to denote the absence of a value when dealing with
   * breakpoint properties.
   */
  int NO_VALUE = -1;

  /**
   * A breakpoint has this ID if it does not reflect an actual breakpoint in a
   * JavaScript VM debugger.
   */
  long INVALID_ID = -1;

  /**
   * @return the breakpoint type
   */
  Type getType();

  /**
   * @return the breakpoint ID as reported by the JavaScript VM debugger
   */
  long getId();

  /**
   * @return whether this breakpoint is enabled
   */
  boolean isEnabled();

  /**
   * Sets whether this breakpoint is enabled.
   *
   * @param enabled whether the breakpoint should be enabled
   */
  void setEnabled(boolean enabled);

  /**
   * @return ignore count for this breakpoint or {@code NO_VALUE} if none
   */
  int getIgnoreCount();

  /**
   * Sets the ignore count for this breakpoint ({@code NO_VALUE} to clear).
   *
   * @param ignoreCount the new ignored hits count to set
   */
  void setIgnoreCount(int ignoreCount);

  /**
   * @return breakpoint condition as plain JavaScript or {@code null} if none
   */
  String getCondition();

  /**
   * Sets the breakpoint condition as plain JavaScript ({@code null} to clear).
   *
   * @param condition the new breakpoint condition
   */
  void setCondition(String condition);

  /**
   * Immediately removes the breakpoint from the JS debugger and invokes the
   * callback once the operation has finished.
   *
   * @param callback to invoke once the operation result is available
   */
  void clear(BrowserTab.BreakpointCallback callback);

  /**
   * Flushes the breakpoint parameter changes (set* methods) into the browser
   * and invokes the callback once the operation has finished. This method must
   * be called for the set* method invocations to take effect.
   *
   * @param callback to invoke once the operation result is available
   */
  void flush(BrowserTab.BreakpointCallback callback);
}
