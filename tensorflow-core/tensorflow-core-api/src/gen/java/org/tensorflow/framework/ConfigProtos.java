// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/protobuf/config.proto

package org.tensorflow.framework;

public final class ConfigProtos {
  private ConfigProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_GPUOptions_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_GPUOptions_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_GPUOptions_Experimental_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_GPUOptions_Experimental_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_GPUOptions_Experimental_VirtualDevices_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_GPUOptions_Experimental_VirtualDevices_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_OptimizerOptions_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_OptimizerOptions_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_GraphOptions_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_GraphOptions_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_ThreadPoolOptionProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_ThreadPoolOptionProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_RPCOptions_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_RPCOptions_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_SessionMetadata_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_SessionMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_ConfigProto_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_ConfigProto_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_ConfigProto_DeviceCountEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_ConfigProto_DeviceCountEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_ConfigProto_Experimental_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_ConfigProto_Experimental_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_RunOptions_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_RunOptions_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_RunOptions_Experimental_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_RunOptions_Experimental_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_RunMetadata_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_RunMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_RunMetadata_FunctionGraphs_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_RunMetadata_FunctionGraphs_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_TensorConnection_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_TensorConnection_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_CallableOptions_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_CallableOptions_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_CallableOptions_FeedDevicesEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_CallableOptions_FeedDevicesEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tensorflow_CallableOptions_FetchDevicesEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tensorflow_CallableOptions_FetchDevicesEntry_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n%tensorflow/core/protobuf/config.proto\022" +
      "\ntensorflow\032*tensorflow/core/framework/c" +
      "ost_graph.proto\032%tensorflow/core/framewo" +
      "rk/graph.proto\032*tensorflow/core/framewor" +
      "k/step_stats.proto\032&tensorflow/core/prot" +
      "obuf/cluster.proto\032$tensorflow/core/prot" +
      "obuf/debug.proto\032.tensorflow/core/protob" +
      "uf/rewriter_config.proto\"\267\005\n\nGPUOptions\022" +
      "\'\n\037per_process_gpu_memory_fraction\030\001 \001(\001" +
      "\022\024\n\014allow_growth\030\004 \001(\010\022\026\n\016allocator_type" +
      "\030\002 \001(\t\022\037\n\027deferred_deletion_bytes\030\003 \001(\003\022" +
      "\033\n\023visible_device_list\030\005 \001(\t\022\"\n\032polling_" +
      "active_delay_usecs\030\006 \001(\005\022$\n\034polling_inac" +
      "tive_delay_msecs\030\007 \001(\005\022\034\n\024force_gpu_comp" +
      "atible\030\010 \001(\010\0229\n\014experimental\030\t \001(\0132#.ten" +
      "sorflow.GPUOptions.Experimental\032\360\002\n\014Expe" +
      "rimental\022K\n\017virtual_devices\030\001 \003(\01322.tens" +
      "orflow.GPUOptions.Experimental.VirtualDe" +
      "vices\022\032\n\022use_unified_memory\030\002 \001(\010\022#\n\033num" +
      "_dev_to_dev_copy_streams\030\003 \001(\005\022\035\n\025collec" +
      "tive_ring_order\030\004 \001(\t\022\035\n\025timestamped_all" +
      "ocator\030\005 \001(\010\022#\n\033kernel_tracker_max_inter" +
      "val\030\007 \001(\005\022 \n\030kernel_tracker_max_bytes\030\010 " +
      "\001(\005\022\"\n\032kernel_tracker_max_pending\030\t \001(\005\032" +
      ")\n\016VirtualDevices\022\027\n\017memory_limit_mb\030\001 \003" +
      "(\002\"\205\003\n\020OptimizerOptions\022+\n#do_common_sub" +
      "expression_elimination\030\001 \001(\010\022\033\n\023do_const" +
      "ant_folding\030\002 \001(\010\022$\n\034max_folded_constant" +
      "_in_bytes\030\006 \001(\003\022\034\n\024do_function_inlining\030" +
      "\004 \001(\010\0225\n\topt_level\030\003 \001(\0162\".tensorflow.Op" +
      "timizerOptions.Level\022E\n\020global_jit_level" +
      "\030\005 \001(\0162+.tensorflow.OptimizerOptions.Glo" +
      "balJitLevel\" \n\005Level\022\006\n\002L1\020\000\022\017\n\002L0\020\377\377\377\377\377" +
      "\377\377\377\377\001\"C\n\016GlobalJitLevel\022\013\n\007DEFAULT\020\000\022\020\n\003" +
      "OFF\020\377\377\377\377\377\377\377\377\377\001\022\010\n\004ON_1\020\001\022\010\n\004ON_2\020\002\"\356\002\n\014G" +
      "raphOptions\022\036\n\026enable_recv_scheduling\030\002 " +
      "\001(\010\0227\n\021optimizer_options\030\003 \001(\0132\034.tensorf" +
      "low.OptimizerOptions\022\030\n\020build_cost_model" +
      "\030\004 \001(\003\022\036\n\026build_cost_model_after\030\t \001(\003\022\024" +
      "\n\014infer_shapes\030\005 \001(\010\022\032\n\022place_pruned_gra" +
      "ph\030\006 \001(\010\022 \n\030enable_bfloat16_sendrecv\030\007 \001" +
      "(\010\022\025\n\rtimeline_step\030\010 \001(\005\0223\n\017rewrite_opt" +
      "ions\030\n \001(\0132\032.tensorflow.RewriterConfigJ\004" +
      "\010\001\020\002R%skip_common_subexpression_eliminat" +
      "ion\"A\n\025ThreadPoolOptionProto\022\023\n\013num_thre" +
      "ads\030\001 \001(\005\022\023\n\013global_name\030\002 \001(\t\"\264\001\n\nRPCOp" +
      "tions\022$\n\034use_rpc_for_inprocess_master\030\001 " +
      "\001(\010\022\035\n\025compression_algorithm\030\002 \001(\t\022\031\n\021co" +
      "mpression_level\030\003 \001(\005\022\032\n\022cache_rpc_respo" +
      "nse\030\004 \001(\010\022*\n\"disable_session_connection_" +
      "sharing\030\005 \001(\010\"0\n\017SessionMetadata\022\014\n\004name" +
      "\030\001 \001(\t\022\017\n\007version\030\002 \001(\003\"\240\n\n\013ConfigProto\022" +
      ">\n\014device_count\030\001 \003(\0132(.tensorflow.Confi" +
      "gProto.DeviceCountEntry\022$\n\034intra_op_para" +
      "llelism_threads\030\002 \001(\005\022$\n\034inter_op_parall" +
      "elism_threads\030\005 \001(\005\022\037\n\027use_per_session_t" +
      "hreads\030\t \001(\010\022G\n\034session_inter_op_thread_" +
      "pool\030\014 \003(\0132!.tensorflow.ThreadPoolOption" +
      "Proto\022\030\n\020placement_period\030\003 \001(\005\022\026\n\016devic" +
      "e_filters\030\004 \003(\t\022+\n\013gpu_options\030\006 \001(\0132\026.t" +
      "ensorflow.GPUOptions\022\034\n\024allow_soft_place" +
      "ment\030\007 \001(\010\022\034\n\024log_device_placement\030\010 \001(\010" +
      "\022/\n\rgraph_options\030\n \001(\0132\030.tensorflow.Gra" +
      "phOptions\022\037\n\027operation_timeout_in_ms\030\013 \001" +
      "(\003\022+\n\013rpc_options\030\r \001(\0132\026.tensorflow.RPC" +
      "Options\022+\n\013cluster_def\030\016 \001(\0132\026.tensorflo" +
      "w.ClusterDef\022\035\n\025isolate_session_state\030\017 " +
      "\001(\010\022(\n share_cluster_devices_in_session\030" +
      "\021 \001(\010\022:\n\014experimental\030\020 \001(\0132$.tensorflow" +
      ".ConfigProto.Experimental\0322\n\020DeviceCount" +
      "Entry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\005:\0028\001\032\232\004" +
      "\n\014Experimental\022\037\n\027collective_group_leade" +
      "r\030\001 \001(\t\022\025\n\rexecutor_type\030\003 \001(\t\022\032\n\022recv_b" +
      "uf_max_chunk\030\004 \001(\005\022\031\n\021use_numa_affinity\030" +
      "\005 \001(\010\0225\n-collective_deterministic_sequen" +
      "tial_execution\030\006 \001(\010\022\027\n\017collective_nccl\030" +
      "\007 \001(\010\0226\n.share_session_state_in_clusters" +
      "pec_propagation\030\010 \001(\010\022\037\n\027disable_thread_" +
      "spinning\030\t \001(\010\022(\n share_cluster_devices_" +
      "in_session\030\n \001(\010\0225\n\020session_metadata\030\013 \001" +
      "(\0132\033.tensorflow.SessionMetadata\022!\n\031optim" +
      "ize_for_static_graph\030\014 \001(\010\022\032\n\022enable_mli" +
      "r_bridge\030\r \001(\010\022\'\n\037disable_output_partiti" +
      "on_graphs\030\016 \001(\010\022#\n\033xla_fusion_autotuner_" +
      "thresh\030\017 \001(\003J\004\010\002\020\003\"\330\003\n\nRunOptions\0226\n\013tra" +
      "ce_level\030\001 \001(\0162!.tensorflow.RunOptions.T" +
      "raceLevel\022\025\n\rtimeout_in_ms\030\002 \001(\003\022\034\n\024inte" +
      "r_op_thread_pool\030\003 \001(\005\022\037\n\027output_partiti" +
      "on_graphs\030\005 \001(\010\022/\n\rdebug_options\030\006 \001(\0132\030" +
      ".tensorflow.DebugOptions\022*\n\"report_tenso" +
      "r_allocations_upon_oom\030\007 \001(\010\0229\n\014experime" +
      "ntal\030\010 \001(\0132#.tensorflow.RunOptions.Exper" +
      "imental\032J\n\014Experimental\022\034\n\024collective_gr" +
      "aph_key\030\001 \001(\003\022\034\n\024use_run_handler_pool\030\002 " +
      "\001(\010\"R\n\nTraceLevel\022\014\n\010NO_TRACE\020\000\022\022\n\016SOFTW" +
      "ARE_TRACE\020\001\022\022\n\016HARDWARE_TRACE\020\002\022\016\n\nFULL_" +
      "TRACE\020\003J\004\010\004\020\005\"\207\003\n\013RunMetadata\022)\n\nstep_st" +
      "ats\030\001 \001(\0132\025.tensorflow.StepStats\022,\n\ncost" +
      "_graph\030\002 \001(\0132\030.tensorflow.CostGraphDef\022." +
      "\n\020partition_graphs\030\003 \003(\0132\024.tensorflow.Gr" +
      "aphDef\022?\n\017function_graphs\030\004 \003(\0132&.tensor" +
      "flow.RunMetadata.FunctionGraphs\032\255\001\n\016Func" +
      "tionGraphs\022.\n\020partition_graphs\030\001 \003(\0132\024.t" +
      "ensorflow.GraphDef\0224\n\026pre_optimization_g" +
      "raph\030\002 \001(\0132\024.tensorflow.GraphDef\0225\n\027post" +
      "_optimization_graph\030\003 \001(\0132\024.tensorflow.G" +
      "raphDef\":\n\020TensorConnection\022\023\n\013from_tens" +
      "or\030\001 \001(\t\022\021\n\tto_tensor\030\002 \001(\t\"\260\003\n\017Callable" +
      "Options\022\014\n\004feed\030\001 \003(\t\022\r\n\005fetch\030\002 \003(\t\022\016\n\006" +
      "target\030\003 \003(\t\022+\n\013run_options\030\004 \001(\0132\026.tens" +
      "orflow.RunOptions\0227\n\021tensor_connection\030\005" +
      " \003(\0132\034.tensorflow.TensorConnection\022B\n\014fe" +
      "ed_devices\030\006 \003(\0132,.tensorflow.CallableOp" +
      "tions.FeedDevicesEntry\022D\n\rfetch_devices\030" +
      "\007 \003(\0132-.tensorflow.CallableOptions.Fetch" +
      "DevicesEntry\022\027\n\017fetch_skip_sync\030\010 \001(\010\0322\n" +
      "\020FeedDevicesEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030" +
      "\002 \001(\t:\0028\001\0323\n\021FetchDevicesEntry\022\013\n\003key\030\001 " +
      "\001(\t\022\r\n\005value\030\002 \001(\t:\0028\001Bw\n\030org.tensorflow" +
      ".frameworkB\014ConfigProtosP\001ZHgithub.com/t" +
      "ensorflow/tensorflow/tensorflow/go/core/" +
      "core_protos_go_proto\370\001\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          org.tensorflow.framework.CostGraphProtos.getDescriptor(),
          org.tensorflow.framework.GraphProtos.getDescriptor(),
          org.tensorflow.framework.StepStatsProtos.getDescriptor(),
          org.tensorflow.distruntime.ClusterProtos.getDescriptor(),
          org.tensorflow.framework.DebugProtos.getDescriptor(),
          org.tensorflow.framework.RewriterConfigProtos.getDescriptor(),
        });
    internal_static_tensorflow_GPUOptions_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tensorflow_GPUOptions_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_GPUOptions_descriptor,
        new java.lang.String[] { "PerProcessGpuMemoryFraction", "AllowGrowth", "AllocatorType", "DeferredDeletionBytes", "VisibleDeviceList", "PollingActiveDelayUsecs", "PollingInactiveDelayMsecs", "ForceGpuCompatible", "Experimental", });
    internal_static_tensorflow_GPUOptions_Experimental_descriptor =
      internal_static_tensorflow_GPUOptions_descriptor.getNestedTypes().get(0);
    internal_static_tensorflow_GPUOptions_Experimental_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_GPUOptions_Experimental_descriptor,
        new java.lang.String[] { "VirtualDevices", "UseUnifiedMemory", "NumDevToDevCopyStreams", "CollectiveRingOrder", "TimestampedAllocator", "KernelTrackerMaxInterval", "KernelTrackerMaxBytes", "KernelTrackerMaxPending", });
    internal_static_tensorflow_GPUOptions_Experimental_VirtualDevices_descriptor =
      internal_static_tensorflow_GPUOptions_Experimental_descriptor.getNestedTypes().get(0);
    internal_static_tensorflow_GPUOptions_Experimental_VirtualDevices_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_GPUOptions_Experimental_VirtualDevices_descriptor,
        new java.lang.String[] { "MemoryLimitMb", });
    internal_static_tensorflow_OptimizerOptions_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_tensorflow_OptimizerOptions_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_OptimizerOptions_descriptor,
        new java.lang.String[] { "DoCommonSubexpressionElimination", "DoConstantFolding", "MaxFoldedConstantInBytes", "DoFunctionInlining", "OptLevel", "GlobalJitLevel", });
    internal_static_tensorflow_GraphOptions_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_tensorflow_GraphOptions_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_GraphOptions_descriptor,
        new java.lang.String[] { "EnableRecvScheduling", "OptimizerOptions", "BuildCostModel", "BuildCostModelAfter", "InferShapes", "PlacePrunedGraph", "EnableBfloat16Sendrecv", "TimelineStep", "RewriteOptions", });
    internal_static_tensorflow_ThreadPoolOptionProto_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_tensorflow_ThreadPoolOptionProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_ThreadPoolOptionProto_descriptor,
        new java.lang.String[] { "NumThreads", "GlobalName", });
    internal_static_tensorflow_RPCOptions_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_tensorflow_RPCOptions_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_RPCOptions_descriptor,
        new java.lang.String[] { "UseRpcForInprocessMaster", "CompressionAlgorithm", "CompressionLevel", "CacheRpcResponse", "DisableSessionConnectionSharing", });
    internal_static_tensorflow_SessionMetadata_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_tensorflow_SessionMetadata_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_SessionMetadata_descriptor,
        new java.lang.String[] { "Name", "Version", });
    internal_static_tensorflow_ConfigProto_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_tensorflow_ConfigProto_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_ConfigProto_descriptor,
        new java.lang.String[] { "DeviceCount", "IntraOpParallelismThreads", "InterOpParallelismThreads", "UsePerSessionThreads", "SessionInterOpThreadPool", "PlacementPeriod", "DeviceFilters", "GpuOptions", "AllowSoftPlacement", "LogDevicePlacement", "GraphOptions", "OperationTimeoutInMs", "RpcOptions", "ClusterDef", "IsolateSessionState", "ShareClusterDevicesInSession", "Experimental", });
    internal_static_tensorflow_ConfigProto_DeviceCountEntry_descriptor =
      internal_static_tensorflow_ConfigProto_descriptor.getNestedTypes().get(0);
    internal_static_tensorflow_ConfigProto_DeviceCountEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_ConfigProto_DeviceCountEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_tensorflow_ConfigProto_Experimental_descriptor =
      internal_static_tensorflow_ConfigProto_descriptor.getNestedTypes().get(1);
    internal_static_tensorflow_ConfigProto_Experimental_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_ConfigProto_Experimental_descriptor,
        new java.lang.String[] { "CollectiveGroupLeader", "ExecutorType", "RecvBufMaxChunk", "UseNumaAffinity", "CollectiveDeterministicSequentialExecution", "CollectiveNccl", "ShareSessionStateInClusterspecPropagation", "DisableThreadSpinning", "ShareClusterDevicesInSession", "SessionMetadata", "OptimizeForStaticGraph", "EnableMlirBridge", "DisableOutputPartitionGraphs", "XlaFusionAutotunerThresh", });
    internal_static_tensorflow_RunOptions_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_tensorflow_RunOptions_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_RunOptions_descriptor,
        new java.lang.String[] { "TraceLevel", "TimeoutInMs", "InterOpThreadPool", "OutputPartitionGraphs", "DebugOptions", "ReportTensorAllocationsUponOom", "Experimental", });
    internal_static_tensorflow_RunOptions_Experimental_descriptor =
      internal_static_tensorflow_RunOptions_descriptor.getNestedTypes().get(0);
    internal_static_tensorflow_RunOptions_Experimental_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_RunOptions_Experimental_descriptor,
        new java.lang.String[] { "CollectiveGraphKey", "UseRunHandlerPool", });
    internal_static_tensorflow_RunMetadata_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_tensorflow_RunMetadata_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_RunMetadata_descriptor,
        new java.lang.String[] { "StepStats", "CostGraph", "PartitionGraphs", "FunctionGraphs", });
    internal_static_tensorflow_RunMetadata_FunctionGraphs_descriptor =
      internal_static_tensorflow_RunMetadata_descriptor.getNestedTypes().get(0);
    internal_static_tensorflow_RunMetadata_FunctionGraphs_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_RunMetadata_FunctionGraphs_descriptor,
        new java.lang.String[] { "PartitionGraphs", "PreOptimizationGraph", "PostOptimizationGraph", });
    internal_static_tensorflow_TensorConnection_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_tensorflow_TensorConnection_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_TensorConnection_descriptor,
        new java.lang.String[] { "FromTensor", "ToTensor", });
    internal_static_tensorflow_CallableOptions_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_tensorflow_CallableOptions_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_CallableOptions_descriptor,
        new java.lang.String[] { "Feed", "Fetch", "Target", "RunOptions", "TensorConnection", "FeedDevices", "FetchDevices", "FetchSkipSync", });
    internal_static_tensorflow_CallableOptions_FeedDevicesEntry_descriptor =
      internal_static_tensorflow_CallableOptions_descriptor.getNestedTypes().get(0);
    internal_static_tensorflow_CallableOptions_FeedDevicesEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_CallableOptions_FeedDevicesEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_tensorflow_CallableOptions_FetchDevicesEntry_descriptor =
      internal_static_tensorflow_CallableOptions_descriptor.getNestedTypes().get(1);
    internal_static_tensorflow_CallableOptions_FetchDevicesEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tensorflow_CallableOptions_FetchDevicesEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    org.tensorflow.framework.CostGraphProtos.getDescriptor();
    org.tensorflow.framework.GraphProtos.getDescriptor();
    org.tensorflow.framework.StepStatsProtos.getDescriptor();
    org.tensorflow.distruntime.ClusterProtos.getDescriptor();
    org.tensorflow.framework.DebugProtos.getDescriptor();
    org.tensorflow.framework.RewriterConfigProtos.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
