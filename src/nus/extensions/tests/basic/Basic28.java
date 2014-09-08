/**
   @author Benjamin Livshits <livshits@cs.stanford.edu>
   
   $Id: Basic28.java,v 1.4 2006/04/04 20:00:40 livshits Exp $
 */
package nus.extensions.tests.basic;

import java.io.IOException;
import java.io.PrintWriter;

import nus.extensions.tests.MainActivity;
import nus.extensions.tests.SinkEmulator;
import nus.extensions.tests.SourceEmulator;

public class Basic28 extends MainActivity {

	public void main(SourceEmulator source, SinkEmulator sink)
	{
		String name = source.getParameter("name");
        boolean b[] = new boolean[3];
        if (b[0]) {
            if (b[0]) {
                if (b[0]) {
                    if (b[0]) {
                        if (b[0]) {
                            if (b[0]) {
                                if (b[0]) {
                                    if (b[0]) {
                                        if (b[0]) {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                                if (b[0]) {
                                }
                            } else {
                            }
                        } else {
                            if (b[0]) {
                                if (b[0]) {
                                    if (b[0]) {
                                    }
                                } else {
                                }
                            } else {
                            }
                        }
                    } else {
                        if (b[0]) {
                            if (b[0]) {
                                if (b[0]) {
                                }
                                sink.println(name);       /* BAD */
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                    if (b[0]) {
                        if (b[0]) {
                            if (b[0]) {
                            }
                        } else {
                        }
                    } else {
                    }
                }
            } else {
                if (b[0]) {
                    if (b[0]) {
                        if (b[0]) {
                            if (b[0]) {
                                if (b[0]) {
                                }
                            } else {
                            }
                        } else {
                            if (b[0]) {
                                if (b[0]) {
                                    if (b[0]) {
                                    }
                                } else {
                                }
                            } else {
                            }
                        }
                    } else {
                        if (b[0]) {
                            if (b[0]) {
                                if (b[0]) {
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                    if (b[0]) {
                        if (b[0]) {
                            if (b[0]) {
                            }
                        } else {
                        }
                    } else {
                        if (b[0]) {
                            if (b[0]) {
                                if (b[0]) {
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                }
            }
        } else {
            if (b[0]) {
                if (b[0]) {
                    if (b[0]) {
                        sink.println(name);       /* BAD */
                    }
                } else {
                }
            } else {
            }
        }
    }

    public String getDescription() {
        return "complicated control flow";
    }

    public int getVulnerabilityCount() {
        return 2;
    }
}